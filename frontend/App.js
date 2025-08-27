import { useState } from "react";
import SearchForm from "./components/SearchForm";
import Dashboard from "./components/Dashboard";

function App() {
  const [results, setResults] = useState([]); // state to store search results

  return (
    <div className="App">
      <h1>GitHub Repo Search</h1>
      <SearchForm onResults={setResults} />
      <Dashboard results={results} />
    </div>
  );
}

export default App;


