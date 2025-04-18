import { BrowserRouter, Route, Routes } from "react-router-dom";
import Header from "./components/layouts/Header";
import Footer from "./components/layouts/Footer";
import Home from "./components/Home";
import Register from "./components/Register";
import 'bootstrap/dist/css/bootstrap.min.css';
import { Container } from "react-bootstrap";
import Login from "./components/Login";

const App = () => {
  return (
    <BrowserRouter>
      <Header />

      <Container>
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/login" element={<Login />} />
          <Route path="/register" element={<Register />} />
        </Routes>
      </Container>
      
      <Footer />
    </BrowserRouter>
  );
};

export default App;