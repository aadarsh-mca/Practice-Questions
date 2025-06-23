const { log } = require("console");
const fs = require("fs");
 
fs.writeFile("test.txt", "First String line", (err) => {
    if(err) {
        console.log(err);
        throw err;
    } 
    console.log("\n=== [ File writing completed !!! ] ===\n");
});

fs.readFile("test.txt", "utf8", (err, data) => {
    if(err) {
        console.log(err);
        throw err;
    } 

    console.log("File data is as follows :: ");
    console.log(data);

    console.log("\n=== [ File writing completed !!! ] ===\n");
})