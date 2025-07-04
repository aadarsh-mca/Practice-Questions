import React from "react";
// import * as React from "react-dom";
import { createRoot } from "react-dom/client";
import App from "./App";

const rootElement = document.getElementById("root");

const root = createRoot(rootElement);

root.render(<App />);