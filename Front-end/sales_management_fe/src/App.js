import logo from './logo.svg';
import './App.css';

import {BrowserRouter as Router, Switch, Route} from 'react-router-dom';
import HeaderComponent from './components/HeaderComponent';
import HomeComponent from './components/HomeComponent';

function App() {
  return (
    <div className="App">
      <Router>
          <HeaderComponent />
            <div className="container">
              <Switch>
                  <Route path = "/" exact component = {HomeComponent}></Route>
                  {/* <Route path = "/employees" component = {ListEmployeeComponent}></Route>
                  <Route path = "/add-employee/:id" component = {CreateEmployeeComponent}></Route>
                  <Route path = "/view-employee/:id" component = {ViewEmployeeComponent}></Route>
                  <Route path = "/login" component = {LoginComponent}></Route>
                  <Route path = "/register" component = {RegisterUserComponent}></Route> */}
                  {/* <Route path = "/update-employee/:id" component = {updateEmployeeComponent}></Route> */}

                
              </Switch>
          </div>
          
      </Router>
    </div>
  );
}

export default App;
