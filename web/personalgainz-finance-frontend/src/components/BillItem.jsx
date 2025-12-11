

// Bill item component to display individual bill details
function BillItem({ bill }) {
    return (
        <li>
            {/* Bill name, amount, and due date */}
            {bill.name} - ${bill.amount} (Due: {bill.dueDate})
        </li>
    );
}

// Export the BillItem component as the default export
export default BillItem;