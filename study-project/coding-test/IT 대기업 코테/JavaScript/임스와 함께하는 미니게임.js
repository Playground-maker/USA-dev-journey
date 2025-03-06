const input = require("fs").readFileSync(0, "utf-8").toString().trim().split("\n");

let [, genre] = input.shift().split(" ");
let people = genre == "Y" ? 1 : genre == "F" ? 2 : 3;

console.log(Math.floor([...new Set(input)].length / people));
