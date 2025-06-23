import React from "react";

function App() {
  const [dateTime, setDateTime] = React.useState({
    date: new Date().toLocaleDateString(),
    time: new Date().toLocaleTimeString()
  });

  function onBtnClick() {
    setDateTime({
      date: new Date().toLocaleDateString(),
      time: new Date().toLocaleTimeString()
    });
  }

  setInterval(onBtnClick, 1000);

  return (
    <div className="container">
      <h1>{dateTime.date}</h1>
      <h2>{dateTime.time}</h2>
      <button onClick={onBtnClick}>Get Time</button>
    </div>
  );
}

export default App;