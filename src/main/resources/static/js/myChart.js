// For a pie chart
new Chart(document.getElementById("myPieChart"), {
    type: 'pie',
// The data for our dataset
    data: {
        labels: ['January', 'February', 'March'],
        datasets: [{
            label: 'My First dataset',
            backgroundColor: ["#3e95cd", "#8e5ea2", "#3cba9f"],
            data: [5, 10, 15]
        }]
    },

// Configuration options go here
    options: {
        title: {
            display: true,
            text: 'Project Statuses'
        }

    }
});