package org.web.application.server.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.web.application.server.dto.EditFriendDTO;
import org.web.application.server.dto.EditUserDTO;
import org.web.application.server.dto.MyPageDTO;
import org.web.application.server.dto.UserDTO;
import org.web.application.server.entity.*;
import org.web.application.server.jwt.JwtProvider;
import org.web.application.server.repository.*;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final GenderRepository genderRepository;
    private final HeightRepository heightRepository;
    private final OccupationRepository occupationRepository;
    private final MajorRepository majorRepository;
    private final WeightRepository weightRepository;
    private final MbtiRepository mbtiRepository;
    private final SnsFrequencyRepository snsFrequencyRepository;
    private final PersonalityRepository personalityRepository;
    private final FaceShapeRepository faceShapeRepository;
    private final MatchingFilterRepository matchingFilterRepository;
    private final LocationRepository locationRepository;
    private final AuthRepository authRepository;
    private final JwtProvider jwtProvider;

    public void saveUser(UserDTO userDTO, String token) {
        //UserDTO를 UserEntity로 변환
        UserEntity userEntity = toUserEntity(userDTO, token);
        System.out.println("Saving user: " + userEntity);
        //UserRepository에 UserEntity로 저장
        userRepository.save(userEntity);
    }

    public UserEntity toUserEntity(UserDTO userDTO, String token) {

        var kakaoId = jwtProvider.validate(token);

        UserEntity userEntity = UserEntity.builder()
                .name(userDTO.getName())
                .genderEntity(genderRepository.findByGender(userDTO.getGender()).orElse(null))
                .age(userDTO.getAge())
                .kakaoId(userDTO.getKakaoId())
                .nickname(userDTO.getNickname())
                .heightEntity(heightRepository.findByHeight(userDTO.getHeight()).orElse(null))
                .faceShapeEntity(faceShapeRepository.findByFaceShapeName(userDTO.getFace()).orElse(null))
                .snsFrequencyEntity(snsFrequencyRepository.findBySnsFrequencyLevel(userDTO.getFrequency()).orElse(null))
                .profile(userDTO.getIntro())
                .majorEntity(majorRepository.findByMajorName(userDTO.getMajor()).orElse(null))
                .mbtiEntity(mbtiRepository.findByMbtiName(userDTO.getMbti()).orElse(null))
                .occupationEntity(occupationRepository.findByOccupationName(userDTO.getOccupation()).orElse(null))
                .personalityEntity(personalityRepository.findByPersonalityName(userDTO.getPersonality()).orElse(null))
                .smoking(userDTO.isSmoke())
                .locationEntity(locationRepository.findByLocationName(userDTO.getState()).orElse(null))
                .weightEntity(weightRepository.findByWeightName(userDTO.getWeight()).orElse(null))
                .authEntity(authRepository.findByKakaoId(Long.valueOf(kakaoId)).get())
                .build();

        jwtProvider.validate(token);

        userRepository.save(userEntity);


        // MatchingFilterEntity를 생성
        MatchingFilterEntity matchingFilterEntity = MatchingFilterEntity.builder()
                .age(userDTO.getWantAge())
                .height(userDTO.getWantHeight())
                .smoking(userDTO.isWantSmoke())
                .userEntity(userEntity)
                .genderEntity(genderRepository.findByGender(userDTO.getWantGender()).orElse(null))
                .occupationEntity(occupationRepository.findByOccupationName(userDTO.getWantOccupation()).orElse(null))
                .build();


        //matchingFilterRepository에 matchingFilterEntity 저장
        matchingFilterRepository.save(matchingFilterEntity);

        return userEntity;
    }

    @Transactional
    public MyPageDTO getMypage(String token)
    {
        System.out.println("=========getMypage()==============");
        System.out.println("token = " + token);

        String kakaoId = jwtProvider.validate(token);

        System.out.println("kakaoId : " + kakaoId);

        var authEntity = authRepository.findByKakaoId(Long.valueOf(kakaoId)).orElse(null);

        System.out.println("authEntity : " + authEntity);

        var userEntity = userRepository.findByAuthEntity(authEntity).orElse(null);

        System.out.println("userEntity : " + userEntity);

        return MyPageDTO.builder()
                .mbti(userEntity.getMbtiEntity().getMbtiName())
                .name(userEntity.getName())
                .gender(userEntity.getGenderEntity().getGender())
                .connectedAt(authEntity.getConnectedAt())
                .age(userEntity.getAge())
                .kakaoId(userEntity.getKakaoId())
                .location(userEntity.getLocationEntity().getLocationName())
                .ninckname(userEntity.getNickname()).build();
    }


    public void editUser(EditUserDTO editUserDTO, String token) {

        String kakaoId = jwtProvider.validate(token);

        System.out.println("kakaoId : " + kakaoId);

        var authEntity = authRepository.findByKakaoId(Long.valueOf(kakaoId)).orElse(null);

        System.out.println("authEntity : " + authEntity);

        var userEntity = userRepository.findByAuthEntity(authEntity).orElse(null);

        System.out.println("userEntity : " + userEntity);

        userEntity.setName(editUserDTO.getName());
        userEntity.setGenderEntity(genderRepository.findByGender(editUserDTO.getGender()).orElse(null));
        userEntity.setAge(editUserDTO.getAge());
        userEntity.setKakaoId(editUserDTO.getKakaoId());
        userEntity.setNickname(editUserDTO.getNickname());
        userEntity.setHeightEntity(heightRepository.findByHeight(editUserDTO.getHeight()).orElse(null));
        userEntity.setFaceShapeEntity(faceShapeRepository.findByFaceShapeName(editUserDTO.getFace()).orElse(null));
        userEntity.setSnsFrequencyEntity(snsFrequencyRepository.findBySnsFrequencyLevel(editUserDTO.getFrequency()).orElse(null));
        userEntity.setProfile(editUserDTO.getIntro());
        userEntity.setMajorEntity(majorRepository.findByMajorName(editUserDTO.getMajor()).orElse(null));
        userEntity.setMbtiEntity(mbtiRepository.findByMbtiName(editUserDTO.getMbti()).orElse(null));
        userEntity.setOccupationEntity(occupationRepository.findByOccupationName(editUserDTO.getOccupation()).orElse(null));
        userEntity.setPersonalityEntity(personalityRepository.findByPersonalityName(editUserDTO.getPersonality()).orElse(null));
        userEntity.setSmoking(editUserDTO.isSmoke());
        userEntity.setLocationEntity(locationRepository.findByLocationName(editUserDTO.getState()).orElse(null));
        userEntity.setWeightEntity(weightRepository.findByWeightName(editUserDTO.getWeight()).orElse(null));

        userRepository.save(userEntity);
    }

    public void editFriend(EditFriendDTO editFriendDTO, String token) {
        System.out.println("=========getUser()==============");
        String kakaoId = jwtProvider.validate(token);

        System.out.println("kakaoId : " + kakaoId);

        var authEntity = authRepository.findByKakaoId(Long.valueOf(kakaoId)).orElse(null);

        System.out.println("authEntity : " + authEntity);

        var userEntity = userRepository.findByAuthEntity(authEntity).orElse(null);

        System.out.println("userEntity : " + userEntity);

        var matchingFilterEntity = matchingFilterRepository.findByUserEntity(userEntity).orElse(null);

        matchingFilterEntity.setAge(editFriendDTO.getWantAge());
        matchingFilterEntity.setHeight(editFriendDTO.getWantHeight());
        matchingFilterEntity.setGenderEntity(genderRepository.findByGender(editFriendDTO.getWantGender()).orElse(null));
        matchingFilterEntity.setOccupationEntity(occupationRepository.findByOccupationName(editFriendDTO.getWantOccupation()).orElse(null));
        matchingFilterEntity.setSmoking(editFriendDTO.isWantSmoke());

        matchingFilterRepository.save(matchingFilterEntity);
    }



    @Transactional
    public UserDTO getAll(String token) {

        System.out.println("=========getAll()==============");
        System.out.println("token = " + token);

        String kakaoId = jwtProvider.validate(token);

        System.out.println("kakaoId : " + kakaoId);

        var authEntity = authRepository.findByKakaoId(Long.valueOf(kakaoId)).orElse(null);

        System.out.println("authEntity : " + authEntity);

        var userEntity = userRepository.findByAuthEntity(authEntity).orElse(null);

        System.out.println("userEntity : " + userEntity);

        var matchingFilterEntity = matchingFilterRepository.findByUserEntity(userEntity).orElse(null);

        System.out.println("matchingFilterEntity = " + matchingFilterEntity);

        UserDTO userDTO = UserDTO.builder()
                .name(userEntity.getName())
                .gender(userEntity.getGenderEntity().getGender())
                .age(userEntity.getAge())
                .kakaoId(userEntity.getKakaoId())
                .nickname(userEntity.getNickname())
                .height(userEntity.getHeightEntity().getHeight())
                .face(userEntity.getFaceShapeEntity().getFaceShapeName())
                .frequency(userEntity.getSnsFrequencyEntity().getSnsFrequencyLevel())
                .intro(userEntity.getProfile())
                .major(userEntity.getMajorEntity().getMajorName())
                .mbti(userEntity.getMbtiEntity().getMbtiName())
                .occupation(userEntity.getOccupationEntity().getOccupationName())
                .personality(userEntity.getPersonalityEntity().getPersonalityName())
                .smoke(userEntity.getSmoking())
                .state(userEntity.getLocationEntity().getLocationName())
                .weight(userEntity.getWeightEntity().getWeightName())
                .wantAge(matchingFilterEntity.getAge())
                .wantGender(matchingFilterEntity.getGenderEntity().getGender())
                .wantHeight(matchingFilterEntity.getHeight())
                .wantOccupation(matchingFilterEntity.getOccupationEntity().getOccupationName())
                .wantSmoke(matchingFilterEntity.getSmoking()).build();

            return userDTO;
    }
}
