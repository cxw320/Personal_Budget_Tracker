import logo from './logo.svg';
import React, {Component} from 'react';
import './App.css';

class TransactionItem extends React.Component {

    constructor(props){
        super(props);
        this.onDelete = this.onDelete.bind(this);
    }


onDelete(){
    const { id } = this.props;
    onDelete(id);
}

  render(){

    const { id, description, category, amount} = this.props;
    return (
      
            <div key={id}>
              <span>{description}</span>{`   |    `}
              <span>{category}</span>{`   |    `}
              <span>{amount}</span>
              <button onClick = {this.onDelete} id={this.props.id}>Delete</button>
            </div>
          
    
    );

  }
}


export default TransactionItem;
