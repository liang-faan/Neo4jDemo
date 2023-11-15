import React from 'react';
import ReactDOM from 'react-dom/client';
import './styles.css';
import CustomApp from './CustomApp';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    {/* <App /> */}
    <CustomApp />
  </React.StrictMode>
);
