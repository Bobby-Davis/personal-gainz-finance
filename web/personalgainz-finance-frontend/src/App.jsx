import Dashboard from "./pages/Dashboard";

// Main application component
function App() {
  return (
    <div style={{ 
      backgroundColor: "#095b66ff",
      minHeight: "100vh",
      color: "#f9fafb",
      width: "100%",
      }}>
      <Dashboard />
    </div>
  );
}

// Export the App component as the default export
export default App;
