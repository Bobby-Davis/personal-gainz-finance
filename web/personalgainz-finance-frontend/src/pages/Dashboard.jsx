import ExpenseDonutChart from "../components/ExpenseDonutChart.jsx";

function Dashboard() {
  // Mock expense data by category
  const expenseData = [
    { category: "Rent", amount: 1200, color: "#8884d8" },
    { category: "Utilities", amount: 200, color: "#82ca9d" },
    { category: "Food", amount: 400, color: "#ffc658" },
    { category: "Transportation", amount: 150, color: "#ff8042" },
    { category: "Misc", amount: 100, color: "#00C49F" },
  ];

  const cardStyle = {
    background: "#0f467eff",
    padding: "1.5rem",
    borderRadius: "16px",
    boxShadow: "0 4px 6px rgba(0, 0, 0, 0.1)",
    display: "flex",
    flexDirection: "column", 
  }

  const totalExpenses = expenseData.reduce((sum, e) => sum + e.amount, 0);

  // Mock income data (in future: calculated from history)
  const income = {
    monthly: 3500,
    annual: 3500 * 12,
    biWeekly: (3500 * 12) / 26,
  };

  // Mock upcoming bills and paychecks
  const upcomingBills = [
    { name: "Rent", date: "2025-01-01", amount: 1200 },
    { name: "Electricity", date: "2025-01-05", amount: 120 },
    { name: "Internet", date: "2025-01-08", amount: 60 },
  ];

  const upcomingPaychecks = [
    { source: "Main Job", date: "2025-01-03", amount: 1350 },
    { source: "Main Job", date: "2025-01-17", amount: 1350 },
  ];

  return (
    <div style={{ padding: "2rem", maxWidth: "1100px", margin: "0 auto" }}>
      <h1 style={{ textAlign: "center", marginBottom: "2rem" }}>
        Dashboard
      </h1>

      {/* Top sections: Expenses (left) and Income (right) */}
      <div
        style={{
          display: "grid",
          gridTemplateColumns: "1fr 1fr",
          gap: "2rem",
          marginBottom: "2rem",
          alignItem: "stretch",
        }}
      >
        {/* Expenses section */}
        <section
          style={cardStyle}>
          <h2>Expenses</h2>
          <p style={{ fontWeight: "bold", marginBottom: "0.5rem" }}>
            Estimated Total Expenses: ${totalExpenses.toFixed(2)}
          </p>

          <ExpenseDonutChart data={expenseData} />

          {/* Legend for colors + amounts */}
          <div style={{ marginTop: "1rem" }}>
            <h3>By Category</h3>
            <ul style={{ listStyle: "none", paddingLeft: 0 }}>
              {expenseData.map((item) => (
                <li
                  key={item.category}
                  style={{
                    display: "flex",
                    alignItems: "center",
                    marginBottom: "0.25rem",
                  }}
                >
                  <span
                    style={{
                      display: "inline-block",
                      width: "14px",
                      height: "14px",
                      borderRadius: "3px",
                      backgroundColor: item.color,
                      marginRight: "0.5rem",
                    }}
                  />
                  <span style={{ flexGrow: 1 }}>{item.category}</span>
                  <span>${item.amount.toFixed(2)}</span>
                </li>
              ))}
            </ul>
          </div>
        </section>

        {/* Income section */}
        <section
          style={cardStyle}>
          <h2>Income</h2>
          <p style={{ fontWeight: "bold", marginBottom: "0.5rem" }}>
            Estimated Monthly Income: ${income.monthly.toFixed(2)}
          </p>
          <p>Estimated Annual Income: ${income.annual.toFixed(2)}</p>
          <p>Estimated Bi-Weekly Income: ${income.biWeekly.toFixed(2)}</p>

          <p style={{ marginTop: "1rem", fontSize: "0.9rem", opacity: 0.8 }}>
            In the future, this will be calculated automatically from:
            bank statements, W-4s, pay stubs, and manual inputs.
          </p>
        </section>
      </div>

      {/* Upcoming bills and paychecks */}
      <div
        style={{
          display: "grid",
          gridTemplateColumns: "1fr 1fr",
          gap: "2rem",
          alignItems: "stretch",
        }}
      >
        <section
          style={cardStyle}>
          <h2>Upcoming Bills</h2>
          <ul style={{ listStyle: "none", paddingLeft: 0 }}>
            {upcomingBills.map((bill, index) => (
              <li
                key={index}
                style={{
                  display: "flex",
                  justifyContent: "space-between",
                  marginBottom: "0.5rem",
                }}
              >
                <span>{bill.name}</span>
                <span>{bill.date}</span>
                <span>${bill.amount.toFixed(2)}</span>
              </li>
            ))}
          </ul>
        </section>

        <section
          style={cardStyle}>
          <h2>Upcoming Paychecks</h2>
          <ul style={{ listStyle: "none", paddingLeft: 0 }}>
            {upcomingPaychecks.map((check, index) => (
              <li
                key={index}
                style={{
                  display: "flex",
                  justifyContent: "space-between",
                  marginBottom: "0.5rem",
                }}
              >
                <span>{check.source}</span>
                <span>{check.date}</span>
                <span>${check.amount.toFixed(2)}</span>
              </li>
            ))}
          </ul>
        </section>
      </div>
    </div>
  );
}

export default Dashboard;
