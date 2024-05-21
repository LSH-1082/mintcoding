import {useNavigate} from "react-router-dom";

const MainFooterOpenMailComponent = () => {
    const navigate = useNavigate();

    //TODO: navigate를 사용했을 때 매칭된 상대방의 정보도 보내기
    return (
        <svg onClick={() => navigate("/matching")} className="plusInCircle" xmlns="http://www.w3.org/2000/svg" width="60" height="60" viewBox="0 0 60 60" fill="none">
            <path fillRule="evenodd" clipRule="evenodd"
                  d="M15.9375 26.25C16.1861 26.25 16.4246 26.3488 16.6004 26.5246C16.7762 26.7004 16.875 26.9389 16.875 27.1875V43.125H43.125V27.1875C43.125 26.9389 43.2238 26.7004 43.3996 26.5246C43.5754 26.3488 43.8139 26.25 44.0625 26.25C44.3111 26.25 44.5496 26.3488 44.7254 26.5246C44.9012 26.7004 45 26.9389 45 27.1875V44.0625C45 44.3111 44.9012 44.5496 44.7254 44.7254C44.5496 44.9012 44.3111 45 44.0625 45H15.9375C15.6889 45 15.4504 44.9012 15.2746 44.7254C15.0988 44.5496 15 44.3111 15 44.0625V27.1875C15 26.9389 15.0988 26.7004 15.2746 26.5246C15.4504 26.3488 15.6889 26.25 15.9375 26.25Z"
                  fill="white" stroke="white" strokeWidth="0.5"/>
            <path fillRule="evenodd" clipRule="evenodd"
                  d="M16.875 21.5625C16.875 21.3139 16.9738 21.0754 17.1496 20.8996C17.3254 20.7238 17.5639 20.625 17.8125 20.625H42.1875C42.4361 20.625 42.6746 20.7238 42.8504 20.8996C43.0262 21.0754 43.125 21.3139 43.125 21.5625V30.3188C43.1249 30.4731 43.0867 30.6251 43.0138 30.7612C42.9408 30.8973 42.8354 31.0132 42.7069 31.0988L30.5194 39.2175C30.3655 39.3199 30.1848 39.3745 30 39.3745C29.8152 39.3745 29.6345 39.3199 29.4806 39.2175L17.2931 31.0988C17.1646 31.0132 17.0592 30.8973 16.9862 30.7612C16.9133 30.6251 16.8751 30.4731 16.875 30.3188V21.5625ZM18.75 22.5V29.8163L30 37.3106L41.25 29.8163V22.5H18.75Z"
                  fill="white" stroke="white" strokeWidth="0.5"/>
            <path fillRule="evenodd" clipRule="evenodd"
                  d="M29.4806 15.157C29.6344 15.0546 29.8151 15 29.9999 15C30.1847 15 30.3654 15.0546 30.5193 15.157L38.9568 20.782L37.9181 22.342L29.9999 17.0639L22.0818 22.342L21.0431 20.782L29.4806 15.157ZM42.8512 24.6483L44.7262 26.5233L43.3987 27.8508L41.5237 25.9758L42.8512 24.6483ZM18.4762 25.9758L16.6012 27.8508L15.2737 26.5233L17.1487 24.6483L18.4762 25.9758ZM23.9062 26.2495C23.9062 26.1252 23.9556 26.006 24.0435 25.9181C24.1314 25.8302 24.2506 25.7808 24.3749 25.7808H35.6249C35.7493 25.7808 35.8685 25.8302 35.9564 25.9181C36.0443 26.006 36.0937 26.1252 36.0937 26.2495C36.0937 26.3738 36.0443 26.4931 35.9564 26.581C35.8685 26.6689 35.7493 26.7183 35.6249 26.7183H24.3749C24.2506 26.7183 24.1314 26.6689 24.0435 26.581C23.9556 26.4931 23.9062 26.3738 23.9062 26.2495ZM24.8437 29.9995C24.8437 29.8752 24.8931 29.756 24.981 29.6681C25.0689 29.5802 25.1881 29.5308 25.3124 29.5308H34.6874C34.8118 29.5308 34.931 29.5802 35.0189 29.6681C35.1068 29.756 35.1562 29.8752 35.1562 29.9995C35.1562 30.1238 35.1068 30.2431 35.0189 30.331C34.931 30.4189 34.8118 30.4683 34.6874 30.4683H25.3124C25.1881 30.4683 25.0689 30.4189 24.981 30.331C24.8931 30.2431 24.8437 30.1238 24.8437 29.9995Z"
                  fill="white" stroke="white" strokeWidth="0.5"/>
        </svg>
    );
}

export default MainFooterOpenMailComponent;