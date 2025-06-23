import path from "path";
import url from "url";

const fileUrl = import.meta.url;
console.log(`File Url ::  ${fileUrl}`);

const filePathFromUrl = url.fileURLToPath(fileUrl);
console.log(`File path :: ${filePathFromUrl}`);

const __dirname = path.dirname(filePathFromUrl);
console.log(`File dirname :: ${__dirname}`);
