import express from "express";
import bodyParser from "body-parser";

const app = express();
const port = 3000;
let brandName = "";
app.use(bodyParser.urlencoded());

app.use(brandNameGenerator);

function brandNameGenerator(req, res, next) {
  brandName = `<h2> Street : ${req.body.street}</h2><h3> Pet : ${req.body.pet}</h3>`;
  next();
}

app.get("/", (req, res) => {
  res.sendFile(import.meta.dirname + "/public/index.html");
});

app.post("/submit", (req, res) => {
  console.log(req.body);
  res.status(200).send(brandName);
});

app.listen(port, () => {
  console.log(`Listening on port ${port}`);
});
