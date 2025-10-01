// const pat1 = /\d/;

// console.log(pat1.test("abc123"));
// console.log(pat1.exec("abc123"));
// // console.log(pat1.match("abc123"));
// // console.log(pat1.matchAll("abc123", "abc456"));

// const str = "This is a test";
// console.log(str.replace(/[A-Z]/g, "-"));  // "This-is-a-test"

// const sentence = "JavaScript, is powerful!";
// console.log(sentence.match(/\b\w+\b/g));  // [ "JavaScript", "is", "powerful" ]


// const date = new Date();
// console.log(date.getFullYear());

// var a = 10;
// let x = 5;
// const y = 20;

// var a = 10;
// // let x = 10;
// // const y = 20;
// console.log(`Before : ${a}`);
// {
//     var a = 20;
//     let x = 10;
//     const y = 20;
// }
// console.log(`After : ${a}`);

// console.log(Math.round(4.5));

// let person = {};
// Object.defineProperty(person, 'name', {
//   value: 'Alice',
//   writable: true,
//   enumerable: true
// });
// console.log(person.name); // Alice


// var str1 = "";
// str1.substring()


console.log(validatePassword("Aadarsh1999@"));


function validatePassword(password) {
  const regex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[\W_]).{8,}$/;
  return regex.test(password);
}
