import express from "express";
const app = new express();
const port = 8080;

const server = app.listen(port, () => {
    console.log(`Server running on port http://localhost:${port}/`);
});

app.get("/", (request, response) => {
    // response.write("<h1>Hello World !!!</h1>");
    response.send("<h1>Home Page</h1>");
});

app.get("/about", (req, res) => {
    res.send("<h1>About Page !!!</h1>");
});

app.get("/contact-us", (req, res) => {
    res.send("<h1>Contact Us Page</h1>")
});

function closeServer() {
    server.close(() => {
        console.log("Server closed !!!");
    });
}
