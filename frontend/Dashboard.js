function Dashboard({ results }) {
  if (!results || results.length === 0) return <p>No results yet.</p>;

  return (
    <div style={{ maxWidth: "800px", margin: "20px auto" }}>
      <h2>Search Results</h2>
      <ul style={{ listStyleType: "none", padding: 0 }}>
        {results.map((repo) => (
          <li key={repo.id} style={{ marginBottom: "16px", borderBottom: "1px solid #ccc", paddingBottom: "8px" }}>
            <a href={repo.url} target="_blank" rel="noreferrer" style={{ fontWeight: "bold", fontSize: "18px" }}>
              {repo.name}
            </a>{" "}
            - ⭐ {repo.stars}
            <p>{repo.description}</p>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default Dashboard;
