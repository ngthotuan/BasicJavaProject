const express = require('express');
const logger = require('morgan');

const apiRouter = require('./routes/api');

const app = express();


app.use(logger('dev'));
app.use(express.json());
app.use(express.urlencoded({ extended: false }));


app.use('/foody/api', apiRouter);


app.use((req, res) => {
  res.status(404).send({message: "oc cho"});
});


module.exports = app;
