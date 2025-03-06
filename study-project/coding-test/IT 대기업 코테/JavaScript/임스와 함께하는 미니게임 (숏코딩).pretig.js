const i=require("fs").readFileSync(0,"utf-8").toString().trim().split("\n");
let [,g]=i.shift().split(" ");
let p=g=="Y"?1:g=="F"?2:3;
console.log(Math.floor([...new Set(i)].length/p));