import inquirer from "inquirer";
import qr from "qr-image";
import fs from "fs";

const qrResult = inquirer.prompt([
    {
        "message": "Enter the URL",
        "name": "URL"
    }
]).then((answer) => {
    const readImgStream = qr.image(answer.URL, { type : "png" });

    const writeImgStream = fs.createWriteStream("qr-img.png");
    
    readImgStream.pipe(writeImgStream);
    // writeImgStream.pipe(readImgStream);

}).catch((error) => {
    console.log(error);
});

// qr.image("Hello QR", )

console.log(qrResult);


