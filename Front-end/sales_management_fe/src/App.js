import logo from './logo.svg';
import './App.css';

import {BrowserRouter as Router,  Route, Switch} from 'react-router-dom';
// import HeaderComponent from './components/HeaderComponent';

import HomeComponent from './components/HomeComponent';
import LoginComponent from './components/LoginComponent';
import RegisterComponent from './components/RegisterComponent';
import ViewProductComponent from './components/ViewProductComponent';
import HeaderComponent from './components/HeaderComponent';
import ChangeInfo from './components/ChangeInfo';

function App() {
  return (
    <div className="App">
      <Router>
       {/* <HomeComponent/> */}
       <HeaderComponent/>
       <Switch>
          <Route path = "/" exact component = {HomeComponent}></Route>
          <Route path="/login" component={LoginComponent}></Route>
          <Route path="/register" component={RegisterComponent}></Route>
          <Route path="/home" component={HomeComponent}></Route>
          <Route path="/view-product/:id" component={ViewProductComponent}></Route>
          <Route path = "/changeinfo" exact component = {ChangeInfo}></Route>
       </Switch>
       
        {/* <Switch>
            <Route path="/" element={<HomeComponent/>}></Route>
            <Route path="/login" element={<LoginComponent/>}></Route>
            <Route path="/register" element={<RegisterComponent/>}></Route>
            <Route path="/home" element={<HomeComponent/>}></Route>
            <Route path="/view-product/:id" element={<ViewProductComponent/>}></Route>
        </Switch>  */}
          
      </Router>
    </div>
  );
}

export default App;
