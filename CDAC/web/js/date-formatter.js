var dayjs = require('dayjs');

const currDate = new Date();
const lastDate = new Date('2025-12-31');

document.writeln(`${new Date(2025, 3, 10)} <br/><br/>`);
document.writeln(currDate + "<br/> <br/>");  // Thu Apr 17 2025 15:41:48 GMT+0530 (India Standard Time)
document.writeln(`Today is ${currDate.getDay()}, ${currDate.getDate()}, Welcome, and Good Afternoon to You <br/><br/>`);
document.writeln(`Number of days left till end of year : ${Math.ceil()} <br/>`);

// console.log(lastDate);
