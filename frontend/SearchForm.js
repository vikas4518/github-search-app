import { useState } from "react";
import axios from "axios";

function SearchForm({ onResults }) {
  const [keyword, setKeyword] = useState("");
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState("");

  const handleSearch = async (e) => {
    e.preventDefault();
    if (!keyword) return;

    setLoading(true);
    setError("");

    try {
      // Call your existing GET endpoint
      const response = await axios.get(
        `http://localhost:8080/api/repos/search?keyword=${keyword}`
      );
      onResults(response.data);
    } catch (err) {
      console.error(err);
      setError("Something went wrong. Try again!");
    } finally {
      setLoading(false);
    }
  };

  return (
    <form
      onSubmit={handleSearch}
      style={{ display: "flex", flexDirection: "column", gap: "8px", maxWidth: "400px", margin: "20px auto" }}
    >
      <input
        type="text"
        value={keyword}
        onChange={(e) => setKeyword(e.target.value)}
        placeholder="Enter keyword..."
        style={{ padding: "8px", fontSize: "16px" }}
      />
      <button type="submit" disabled={loading} style={{ padding: "8px", fontSize: "16px" }}>
        {loading ? "Searching..." : "Search"}
      </button>
      {error && <p style={{ color: "red" }}>{error}</p>}
    </form>
  );
}

export default SearchForm;
