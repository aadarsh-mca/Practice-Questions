//To see how the final website should work, run "node solution.js".
//Make sure you have installed all the dependencies with "npm i".
//The password is ILoveProgramming

import express from "express";
import bodyParser from "body-parser";

const app = express();
const port = 3000;
const adminPassword = "ILoveProgramming";
let isUserAuthorised = false;
app.use(bodyParser.urlencoded());

app.get("/", (req, res) => {
    res.sendFile(`${import.meta.dirname}/public/index.html`);
});

app.use("/check", verifyPassword);
function verifyPassword(req, res, next) {
    if(req.body.password === adminPassword) {
        isUserAuthorised = true;
    } else {
        isUserAuthorised = false;
    }
    // isUserAuthorised = req.body.password === adminPassword ? true : false;
    next();
}

app.post("/check", (req, res) => {
    if(isUserAuthorised) {
        res.sendFile(`${import.meta.dirname}/public/secret.html`);
    } else {
        res.redirect("/");
        // res.sendFile(`${import.meta.dirname}/public/index.html`);
    }
});

app.listen(port, () => {
    console.log(`Server running on ${port}.........`);
});
