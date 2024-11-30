const canvas = document.getElementById('gameCanvas');
const ctx = canvas.getContext('2d');
const startBtn = document.getElementById('startBtn');
const resetBtn = document.getElementById('resetBtn');
const instructions = document.getElementById('instructions');

let vertices = [];
let currentPath = [];
let isDrawing = false;

canvas.width = 600;
canvas.height = 600;

// Generate a star shape with random vertices
function generateStar(numPoints) {
    vertices = [];
    const innerRadius = 100;
    const outerRadius = 200;
    const angleIncrement = Math.PI / numPoints;

    for (let i = 0; i < numPoints * 2; i++) {
        const radius = i % 2 === 0 ? outerRadius : innerRadius;
        const angle = i * angleIncrement;
        const x = 300 + radius * Math.cos(angle);
        const y = 300 + radius * Math.sin(angle);
        vertices.push({ x, y });
    }
}

// Draw the shape and the vertices
function draw() {
    ctx.clearRect(0, 0, canvas.width, canvas.height);
    
    // Draw the star shape with low opacity
    ctx.strokeStyle = 'rgba(0, 122, 255, 0.3)'; // Light blue with low opacity
    ctx.lineWidth = 2;
    ctx.beginPath();
    vertices.forEach((vertex) => {
        ctx.lineTo(vertex.x, vertex.y);
        ctx.arc(vertex.x, vertex.y, 5, 0, 2 * Math.PI); // Draw dots
    });
    ctx.closePath();
    ctx.stroke();

    // Draw current path with high opacity
    ctx.strokeStyle = 'red'; // Solid red for user path
    ctx.lineWidth = 4;
    ctx.beginPath();
    if (currentPath.length > 0) {
        ctx.moveTo(currentPath[0].x, currentPath[0].y);
        currentPath.forEach(vertex => {
            ctx.lineTo(vertex.x, vertex.y);
        });
        // Connect back to starting point for visibility
        ctx.lineTo(currentPath[0].x, currentPath[0].y);
    }
    ctx.stroke();
}

// Start the game
startBtn.addEventListener('click', () => {
    generateStar(5); // A star shape with 5 points
    currentPath = [];
    draw();
    isDrawing = true;
});

// Reset the game
resetBtn.addEventListener('click', () => {
    currentPath = [];
    draw();
});

// Handle mouse movement to connect dots
canvas.addEventListener('mousedown', (event) => {
    if (!isDrawing) return;

    const rect = canvas.getBoundingClientRect();
    const mouseX = event.clientX - rect.left;
    const mouseY = event.clientY - rect.top;

    const closestVertex = vertices.reduce((closest, vertex) => {
        const dist = Math.hypot(vertex.x - mouseX, vertex.y - mouseY);
        return dist < closest.distance ? { vertex, distance: dist } : closest;
    }, { distance: Infinity }).vertex;

    if (!currentPath.includes(closestVertex)) {
        currentPath.push(closestVertex);
        draw();
    }
});

// Check if all dots are connected when mouse is released
canvas.addEventListener('mouseup', () => {
    if (isDrawing && currentPath.length > 0 && currentPath[0] === currentPath[currentPath.length - 1] && currentPath.length === vertices.length) {
        alert('Congratulations! You connected all dots back to the start.');
        isDrawing = false;
    }
});

// Handle mouse movement to show the path
canvas.addEventListener('mousemove', (event) => {
    if (!isDrawing || currentPath.length === 0) return;

    const rect = canvas.getBoundingClientRect();
    const mouseX = event.clientX - rect.left;
    const mouseY = event.clientY - rect.top;

    const closestVertex = vertices.reduce((closest, vertex) => {
        const dist = Math.hypot(vertex.x - mouseX, vertex.y - mouseY);
        return dist < closest.distance ? { vertex, distance: dist } : closest;
    }, { distance: Infinity }).vertex;

    if (!currentPath.includes(closestVertex)) {
        ctx.clearRect(0, 0, canvas.width, canvas.height);
        draw();
        ctx.beginPath();
        ctx.moveTo(currentPath[currentPath.length - 1].x, currentPath[currentPath.length - 1].y);
        ctx.lineTo(mouseX, mouseY);
        ctx.strokeStyle = 'red'; // Solid red for user path
        ctx.lineWidth = 4;
        ctx.stroke();
    }
});
