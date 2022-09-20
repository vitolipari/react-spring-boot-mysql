import logo from './logo.svg';
import './App.css';
import React, { useState } from "react";

function App() {

    const [students, setStudents] = useState();
    const [inWait, wait] = useState();
    if( !students && !inWait ) {
        wait( true );
        setTimeout(
            () => {
                fetch("/api/v1/student")
                    .then( response => response.json() )
                    .then( response => {
                        console.log("students");
                        console.log( response );
                        wait( false );
                        setStudents( response );
                    })
                    .catch( e => {
                        console.log("errore");
                        console.log( e );
                    })
            },
            5000
        );
    }


  return (
    <div className="App">
      <header className="App-header">
        {
            !!students
                ? (
                    <pre style={{ textAlign: "left" }}>
                        {
                            students
                                .map( student => JSON.stringify(student, "\t", 2) )
                        }
                    </pre>
                )
                : (
                    <React.Fragment>
                        <img src={logo} className="App-logo" alt="logo" />
                        <p>
                          Edit <code>src/App.js</code> and save to reload.
                        </p>
                        <a
                          className="App-link"
                          href="https://reactjs.org"
                          target="_blank"
                          rel="noopener noreferrer"
                        >
                          Learn React
                        </a>
                    </React.Fragment>
                )
        }
      </header>
    </div>
  );
}

export default App;
