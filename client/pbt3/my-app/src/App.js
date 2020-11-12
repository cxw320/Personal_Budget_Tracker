import logo from './logo.svg';
import React, {Component} from 'react';
import './App.css';
import TransactionItem from './TransactionItem';

class App extends React.Component {

  constructor(props){

    super(props);

    this.state = {

        allTransactions: [],
        apiResponse: ""
    }


    this.onDelete = this.onDelete.bind(this);
  }


  callAPI(){
    fetch("http://localhost:8080/transactions/all")
      .then(res => res.json())
      .then(res => this.setState({allTransactions: res}));
      console.log(this.state.allTransactions);
  }


  componentWillMount(){
    const transactions = this.getTransactions();
    this.setState({transactions});
    
  }

  getTransactions(){
    this.callAPI();
  }

  onDelete(id){
		console.log('deleteTask method hit');
		
		const url = 
		`http://localhost:8080/transactions/${id}`;
		
		console.log(url);
		const options = {
			method: 'DELETE',
			mode: 'cors',
		};
		
	

  }

  render(){
    return (


      <div className="App">
        <h1> Personal Budget Tracker </h1>
      {
        this.state.allTransactions.map(transaction =>{
          return(
           <TransactionItem
            key={transaction.id}
            description={transaction.description}
            category={transaction.category}
            amount={transaction.amount}
            onDelete={this.onDelete}  
            />
           
          );
        })
      }

     </div>
    );

  }
}


export default App;
