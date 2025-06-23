import React, {useState} from "react";
import ToDoItem from "./ToDoItem.jsx";

export default function App() {

  const [appState, setAppState] = useState({
    user: "Aadarsh Yadav",
    inputText: "",
  });
  const [toDoList, setToDoList] = useState([]);

  function handleInputTextOnChange(event) {
    const {name, value} = event.target;

    setAppState(
      (prevAppState) =>  {
        return {
          ...prevAppState,
          [name]: value,
        };
    });
  }

  function handleAddBtnOnClick() {
    if(appState.inputText !== "") {

      setToDoList((prevToDoList) => {
        var lastItemKey = prevToDoList.length == 0 ? 0 : prevToDoList.at(-1).key;

        console.log(lastItemKey);
      
        return [
          ...prevToDoList, 
          {
            key: lastItemKey + 1,
            inputText: appState.inputText,
          }
        ];
      });

      setAppState((prevAppState) => {
        return {
          ...prevAppState,
          inputText: "",
        };
      });
    }
  }

  function handleToDoItemOnClick(data) {
    console.log(data);
    
    setToDoList((prevToDoList) => {
      let index = prevToDoList.findIndex((item) => item.key === data.key);

      prevToDoList.splice(index, 1);

      return [...prevToDoList];
    });
  }

  return (
    <div className="container">
      <div className="heading">
        <h1>To-Do List</h1>
      </div>
      <div className="form">
        <input 
          type="text"
          name="inputText" 
          onChange={handleInputTextOnChange} 
          value={appState.inputText} 
        />
        
        <button onClick={handleAddBtnOnClick}>
          <span>Add</span>
        </button>
      </div>
      <div>
        <ul>
          {toDoList.map((data) => <ToDoItem 
              key={data.key} 
              data={data}
              onClick={handleToDoItemOnClick} 
            />)}
        </ul>
      </div>
    </div>
  );
}