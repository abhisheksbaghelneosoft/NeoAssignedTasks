import React from 'react';
import './App.css';
import { BrowserRouter,Route,Routes } from 'react-router-dom';
import Try from './Try';
import Demo from './Components/Demo';

function App() {
  return (
    <BrowserRouter>
        <Routes>
          <Route path='/try' element={<Try/>} />
          <Route path='/demo' element={<Demo/>} />
        </Routes>
    </BrowserRouter>

  );
}

export default App;


<BrowserRouter>
        <Routes>
          <Route path='/try' element={<Try/>} />
        </Routes>
    </BrowserRouter>