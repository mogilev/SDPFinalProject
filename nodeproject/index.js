const express = require ('express');
const morgan = require('morgan');
const cors = require('cors');
const bodyParser = require('body-parser');

const app = express();
app.use(express.static('public'));
app.use(morgan('dev'));
app.use(bodyParser.urlencoded({ extended: false }));
app.use(bodyParser.json());
app.use(cors());

const data = [];

app.listen(3000, () => console.log('Express started at http://localhost:3000'));


app.get('http://localhost:8080/', (req, res) => {
    return res.json({data});
});
