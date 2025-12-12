import { PieChart, Pie, Cell, Tooltip } from "recharts";

function ExpenseDonutChart({ data }) {
  const total = data.reduce((sum, item) => sum + item.amount, 0);

  return (
    <div style={{ display: "flex", justifyContent: "center" }}>
      <PieChart width={260} height={260}>
        <Pie
          data={data}
          dataKey="amount"
          nameKey="category"
          cx="50%"
          cy="50%"
          innerRadius={70}  // inner radius makes it a "donut"
          outerRadius={100}
          paddingAngle={2}
        >
          {data.map((entry) => (
            <Cell key={entry.category} fill={entry.color} />
          ))}
        </Pie>
        <Tooltip
          formatter={(value, name) => [
            `$${value.toFixed(2)}`,
            `${name} (${((value / total) * 100).toFixed(1)}%)`,
          ]}
        />
      </PieChart>
    </div>
  );
}

export default ExpenseDonutChart;
