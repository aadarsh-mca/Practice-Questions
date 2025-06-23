import React from "react";
import Header from "./Header";
import Footer from "./Footer";
import Note from "./Note";
import notesData from "../assets/notes";

function App() {
  return (
    <div>
      <Header />

      {notesData.map(note => <Note key={note.key} note={note} />)}

      <Footer />
    </div>
  );
}

export default App;  