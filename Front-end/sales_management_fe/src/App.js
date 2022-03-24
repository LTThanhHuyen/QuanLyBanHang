import logo from './logo.svg';
import './App.css';

import {BrowserRouter as Router,  Route, Routes} from 'react-router-dom';
import HeaderComponent from './components/HeaderComponent';
import HomeComponent from './components/HomeComponent';
import LoginComponent from './components/LoginComponent';
import RegisterComponent from './components/RegisterComponent';

function App() {
  return (
    <div className="App">
      <Router>
        <HeaderComponent></HeaderComponent>
        <Routes>
            <Route path="/" element={<LoginComponent/>}></Route>
            <Route path="/register" element={<RegisterComponent/>}></Route>
            <Route path="/home" element={<HomeComponent/>}></Route>
        </Routes>
          
      </Router>
    </div>
  );
}

export default App;
