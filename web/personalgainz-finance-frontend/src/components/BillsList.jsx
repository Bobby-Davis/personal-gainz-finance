import BillItem from "./BillItem";

// this component displays a list of monthly bills
function BillsList() {

    // Sample data for demonstration purposes
    const sampleBills = [
        { id: 1, name: 'Electricity', amount: 60.00, dueDate: '2024-07-10' },
        { id: 2, name: 'Water', amount: 30.00, dueDate: '2024-07-15' },
        { id: 3, name: 'Internet', amount: 45.00, dueDate: '2024-07-20' },
    ];

    // Render the list of bills
    return (
        <div>
            {/*Title for the bills section*/}
            <h2>Monthly Bills</h2>
            <ul>
                {/* Iterate over the sample bills and display each one and its details */}
                {sampleBills.map(bill => (
                    <BillItem key={bill.id} bill={bill} />
                ))}
            </ul>
        </div>
    );
}

// Export the BillsList component as the default export
export default BillsList;