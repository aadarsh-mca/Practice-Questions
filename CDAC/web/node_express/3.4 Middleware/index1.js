import bodyParser from "body-parser";
import express from "express";
import morgan from "morgan";
import { dirname } from "path";
import { fileURLToPath } from "url";
const __dirname = dirname(fileURLToPath(import.meta.url));

const app = express();
const port = 3000;

app.use(bodyParser.urlencoded());

app.use((req, res, next) => {
  console.log(`${req.headers.host}/${req.method}`);
  next();
})

app.use((req, res, next) => {
  console.log(req.body);
  next();
});

app.use(morgan("tiny"));

app.get("/", (req, res) => {
  res.sendFile(import.meta.dirname + "/public/index.html");
});

app.post("/submit", (req, res) => {
  // console.log(req.body);
});

app.listen(port, () => {
  console.log(`Listening on port ${port}`);
});
