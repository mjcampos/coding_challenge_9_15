var root = document.getElementById('root');  // Get root div
var childNodeTemplate = document.createElement("div");  // Create a template for all the blocks that will be on display in the root div

// Initiate the child templates with the CSS style of black
childNodeTemplate.classList.add("black");

// Add the child templates on the HTML based on the number you want on display
for(var i = 0; i < 30; i++) {
	var node = childNodeTemplate.cloneNode(true);

	node.id = i + 1;

	node.addEventListener("click", event => {
		var id = event.toElement.id;
		var className = event.toElement.className;
		var messageDiv = document.getElementById("message");

		if(className === "black") {
			// Change class to blue
			event.toElement.className = "blue";

			// Display message "Turning ON ${id}"
			messageDiv.innerText = `Turning ON ${id}`;
		} else {
			// Change class to black
			event.toElement.className = "black";

			// Display message "Turning ON ${id}"
			messageDiv.innerText = `Turning OFF ${id}`;
		}
	})

	root.appendChild(node);
}