import {BrowserRouter, Routes, Route} from 'react-router-dom';
import './App.css';
import Login from "./login/Login";
import Main from "./main/Main";
import Register from "./register/Register";
import Profile from "./profile/Profile";
import MatchingCheck from "./matching/matchingCheck";
import RoommatePage from "./roommate/RoommatePage";
import AlarmPage from "./alarm/AlarmPage";


function App() {
    return (
        <div className="App">
            <div className="appDiv">
                <BrowserRouter>
                    <Routes>
                        <Route path="/" element={<Login/>}></Route>
                        <Route path="/register" element={<Register/>}></Route>
                        <Route path="/main" element={<Main/>}></Route>
                        <Route path="/matchingCheck" element={<MatchingCheck/>}></Route>
                        <Route path="/alarm" element={<AlarmPage/>}></Route>
                        <Route path="/profile" element={<Profile/>}></Route>
                        <Route path="/roommate" element={<RoommatePage/>}></Route>
                        {/* 상단에 위치하는 라우트들의 규칙을 모두 확인, 일치하는 라우트가 없는경우 처리 */}
                    </Routes>
                </BrowserRouter>
            </div>
        </div>
    );
}

export default App;
