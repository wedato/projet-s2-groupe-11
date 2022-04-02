/*
Juste un try de nodeJS
 */
const http = require('http');
const app = require('./experimentalNodeJsBackend/app');
const debug = require('debug')('node-angular')

// check if port is a number
const normalizePort = val => {
  var port = parseInt(val, 10);

  if (isNaN(port))
    return val;
  if (port >= 0)
    return port;

  return false;
}

// check type of error and log somethind diff according
const onError = error => {
  if (error.syscall !== "listen")
    throw error;
  const bind = typeof addr === "string" ? "pipe" + addr : "port " + port;
  switch (error.code) {
    case "EACCES":
      console.error(bind + " requires elevated privilieges");
      process.exit(1);
      break;
    case "EADDRINUSE":
      console.error(bind + " is already in use");
      process.exit(1);
      break;
    default:
      throw error;

  }
};

// just input that we are now listening
const onListening = () => {
  const addr = server.address();
  const bind = typeof addr === "string" ? "pipe " + addr : "port " + port;
  debug("Listening on " +bind)
}


const port = normalizePort(process.env.PORT || 3000);
app.set('port', port)
const server = http.createServer(app);
server.on("error" , onError);
server.on("listening",onListening)

server.listen(port);
