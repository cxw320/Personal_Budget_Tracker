import logo from './logo.svg';
import React, {useState, useEffect} from 'react';
import './App.css';
import Transaction from './Transaction.js';
import AddTransaction from './AddTransaction.js';

const App = () =>{

  const dummyData = [ 
    { id: 1,
      description: 'test',
      category: 'test',
      amount: 100},
    { id: 2,
      description: 'store',
      category: 'food',
      amount: 200}
  ]


  //Move the iteration logic to view
  const [transactionList, setTransactionList] = useState(dummyData);

  var transactions = transactionList.map((transaction) =>{
      const{id, description, category, amount} = transaction;

      return( 
          <Transaction id={id} description={description} category={category}
                amount={amount}/>
      )    
  });



  const addTransaction = newTransaction => {

    const url = "http://localhost:8080/transactions";
    const options = {

      method: 'POST',
      mode: 'cors',
      headers:{
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(newTransaction)
    };

    let response = fetch(url, options);
    let data = response.json();
    //this.setState({allTransactions: data});

  }


  return (

  <main>  

    <AddTransaction AddTransaction={AddTransaction}/>

    <table>
       <thead>
         <tr>
           <th>Description</th>
           <th>Category</th>
           <th>Amount</th>
         </tr>
       </thead>
      <tbody>
        {transactions}
      </tbody>
    </table>

  </main>


  )


};


export default App;
