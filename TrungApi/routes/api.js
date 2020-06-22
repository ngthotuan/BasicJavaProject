const express = require('express');
const mysql = require('mysql');


const router = express.Router();



const con = mysql.createConnection({
    host: "databaseforandroid.cfhu6nbagtxd.us-west-2.rds.amazonaws.com",
    user: "toantrungp999",
    password: "toantrung123456789",
    database: "Foody"
});

router.get('/province', (req, res) => {
    const sql = "SELECT * FROM Province";
    con.query(sql, function(err, results) {
        if (err) throw err;
        res.send(results);
    });
});

router.get('/restaurant/province/:id', (req, res) => {
    const sql = "SELECT * FROM Restaurant WHERE province_id = ?";
    con.query(sql,[req.params.id], (err, results) => {
        if(err){
            res.status(400).send({message: "invalid param!"});
        }
        else if(results.length === 0){
            res.status(404).send({message: "not found province_id!"});
        }
        else{
            res.send(results);
        }
    });
});

router.get('/restaurant/food/:res_id', (req, res) => {
    const sql = "SELECT * FROM Food WHERE res_id = ?";
    con.query(sql,[req.params.res_id], (err, results) => {
        if(err){
            res.status(400).send({message: "invalid param!"});
        }
        else if(results.length === 0){
            res.status(404).send({message: "not found restaurant!"});
        }
        else{
            res.send(results);
        }
    });
});

router.get('/province/:id', (req, res) => {

    // const sql = `SELECT * FROM Province WHERE province_id = ${req.params.id}`;
    //sql injection
    const sql = "SELECT * FROM Province WHERE province_id = ?";
    con.query(sql,[req.params.id], (err, results) => {
        if(err){
            res.status(400).send({message: "invalid param!"});
        }
        else if(results.length === 0){
            res.status(404).send({message: "not found province_id!"});
        }
        else{
            res.send(results);
        }
    });

});

router.get('/type_food/:res_id', (req, res) => {

    // const sql = `SELECT * FROM Type_Food WHERE res_id = ${req.params.id}`;
    //sql injection
    const sql = "SELECT * FROM Type_Food WHERE res_id = ?";
    con.query(sql,[req.params.res_id], (err, results) => {
        if(err){
            res.status(400).send({message: "invalid param!"});
        }
        else if(results.length === 0){
            res.status(404).send({message: "not found restaurant_id!"});
        }
        else{
            res.send(results);
        }
    });
});

router.get('/menu/:res_id', (req, res) => {
    const sql = "SELECT * FROM Menu_image WHERE res_id = ?";
    con.query(sql,[req.params.res_id], (err, results) => {
        if(err){
            res.status(400).send({message: "invalid param!"});
        }
        else if(results.length === 0){
            res.status(404).send({message: "not found menu image!"});
        }
        else{
            res.send(results);
        }
    });
});


router.get('/wifi/:res_id', (req, res) => {
    const sql = "SELECT * FROM Wifi WHERE res_id = ?";
    con.query(sql,[req.params.res_id], (err, results) => {
        if(err){
            res.status(400).send({message: "invalid param!"});
        }
        else if(results.length === 0){
            res.status(404).send({message: "not found wifi!"});
        }
        else{
            res.send(results);
        }
    });
});

//insert
router.post('/wifi', (req, res) => {
    const {name, password, res_id} = req.body;
    const sql = "insert into Wifi(name, password, res_id) values(?, ?, ?)";

    con.query(sql, [name, password, res_id] ,(err, results) => {
        if(err){
            res.status(400).send({message: err.sqlMessage});
        }
        else{
            //return id inserted
            res.send({message: `id inserted: ${results.insertId}`});
        }
    });
});

//update wifi by id
router.put('/wifi', (req, res) => {
    const {name, password, res_id, wifi_id} = req.body;
    const sql = "update Wifi set name = ?, password = ?, res_id = ? where wifi_id = ?";

    if(wifi_id === undefined){
        res.status(401).json({"message": "wifi_id is require!"});
    }
    else{
        con.query(sql, [name, password, res_id, wifi_id] ,(err, results) => {
            if(err) {
                res.status(400).send({message: err.sqlMessage});
            }
            else{
                //return the number of row(s) affect
                res.send({message: results.message});
            }
        });
    }
});


module.exports = router;