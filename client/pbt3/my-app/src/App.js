import React, {useState, useEffect} from 'react';
import Transaction from './Transaction.js';
import AddTransaction from './AddTransaction.js';
import API from "./utils/API";
import {Row, Col, Container} from 'react-bootstrap';
import styles from './index.css';
import StackedBarChart from './StackedBarChart';


const App = () =>{


  const [transactionList, setTransactionList] = useState([]);

  useEffect(()=>{
    loadTransactions().then(()=>{
      console.log('transactions loaded')
    })        
  },[])




  const loadTransactions = async () => {
    const transactions = await API.get('/transactions/all');
    setTransactionList(transactions)
  }




  return (


  <main>  
    <Container>

    <AddTransaction callback={loadTransactions}/>

    <Row>

      <Col className="text-center">
     <p className="text-center"> description </p>

      </Col>
      <Col>
      Category
      </Col>
      <Col>
        Amount
      </Col>

      <Col>
      </Col>
    </Row>

   
      
    {transactionList.map((transaction)=>(
       <Row className="text-center" id={transaction.id}>    <Transaction callback={loadTransactions} id={transaction.id} description={transaction.description}
          category={transaction.category} amount={transaction.amount}  />
          </Row>
        ))
      }

    <StackedBarChart />

    </Container>
  </main>


  )


};


export default App;
