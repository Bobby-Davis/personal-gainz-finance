import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import BillsList from './components/BillsList';

// app component serves as the main entry point for the PersonalGainz Finance frontend application
function App() {
  // shows the main application structure
  return (
    <div style={{ 
      minHeight: "100vh",
      display: "flex",
      flexDirection: "column",
      alignItems: "center",
      justifyContent: "center",
      }}
    >
      <h1>PersonalGainz Finance</h1>
      <BillsList />
    </div>    
  );
}

export default App
