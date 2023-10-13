import React, { useEffect, useState } from 'react';
import { getAllNotes } from './api/notes.api'
import { Container, Navbar, Nav, Card } from 'react-bootstrap';
import 'bootstrap/dist/css/bootstrap.min.css';
import './App.css'

function App() {
  const [notes, setNotes] = useState([]);

  useEffect(() => {
   async function loadNotes() {
      const res = await getAllNotes()
      setNotes(res.data);
    }
    loadNotes();
  }, []);

  return (
    <div>
      {/* Header */}
      <Navbar className="header" style={{backgroundColor: "#1976D2"}} variant="dark">
        <Navbar.Brand href="#">NoteNexus</Navbar.Brand>
        <Nav className="ml-auto">
          <Nav.Link href="#">Icon1</Nav.Link>
          <Nav.Link href="#">Icon2</Nav.Link>
          <Nav.Link href="#">Avatar</Nav.Link>
        </Nav>
      </Navbar>
      
      {/* Hero: Notes Cards */}
      <Container className="hero mt-3"> {/* Asegúrate de añadir la clase "hero" */}
        {notes.map((note) => (
          <Card className="mb-3" key={note.id} style={{backgroundColor: "#1C1C1C", color: "#fff"}}>
            <Card.Body>
              <Card.Title>{note.title}</Card.Title>
              <Card.Text>{note.content}</Card.Text>
            </Card.Body>
          </Card>
        ))}
      </Container>
      
      {/* Footer */}
      <footer style={{backgroundColor: "#1976D2"}} className="text-center p-3">
        <div className="d-flex justify-content-around">
          <span>Icon1</span>
          <span>Icon2</span>
          <span>Icon3</span>
          <span>Icon4</span>
          <span>Icon5</span>
        </div>
      </footer>
    </div>
  )
}

export default App
