import logo from './logo.svg';
import './App.css';

import {BrowserRouter as Router} from 'react-router-dom';
import HeaderComponent from './components/HeaderComponent';

function App() {
  return (
    <div className="App">
      <Router>
          <HeaderComponent />
            
      </Router>
    </div>
  );
}

export default App;
