

function fetchExpenses(){
    fetch('http://localhost:8080/expenses/list')
    .then(response => response.json())
    .then(expenses =>{
        renderExpenses(expenses);
    })
    .catch(error => {
        console.error("Error Fetching Expenses");
    });
}

function renderExpenses(expenses){
    const expensesTable = document.getElementById("expensesTable");
    expensesTable.innerHTML="";
    expenses.forEach(element => {
        const row = document.createElement("tr");
        row.innerHTM=`
        <td>${expenses.description}</td>
        <td>${expenses.amount}</td>
        <td>${expenses.date}</td>
        `;
        expensesTable.appendChild(row);
    });
}

function addExpense(){
const desc = document.getElementById("description");
const amount = document.getElementById("amount");
const date = document.getElementById("date");
const exp ={
    description : desc.value,
    amount : amount.value,
    date : date.value
}
fetch('http://localhost:8080/expenses/log', {
    method:'POST',
    headers:{
        'Content-Type' : 'application/json',
        'Authentication': `Bearer+${jwt}`
    },
    body : JSON.stringify(exp)
})
.then(response => response.json())
.catch(error => {
    console.error("Error Fetching Expenses");
});
}