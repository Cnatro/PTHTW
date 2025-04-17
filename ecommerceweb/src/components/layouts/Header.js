import { useEffect, useState } from "react";
import { Button, Container, Form, Nav, Navbar, NavDropdown } from "react-bootstrap";
import Apis, { endpoints } from "../../configs/Apis";
import { Link, useNavigate } from "react-router-dom";

const Header = () => {
    const [categories, setCategories] = useState([]);
    const [kw, setKw] = useState();
    const nav = useNavigate();

    let loadCates = async () => {
        let res = await Apis.get(endpoints['categories']);
        setCategories(res.data);
    };


    useEffect(() => {
        loadCates();
    }, []);

    const search = (e) => {
        e.preventDefault();
        if (kw && kw.trim() !== "")
            nav(`/?kw=${kw}`);
    };

    return (
        <Navbar expand="lg" className="bg-body-tertiary">
            <Container>
                <Navbar.Brand href="#home">React-Bootstrap</Navbar.Brand>
                <Navbar.Toggle aria-controls="basic-navbar-nav" />
                <Navbar.Collapse id="basic-navbar-nav">
                    <Nav className="me-auto">
                        <Link to="/" className="nav-link">Trang Chu</Link>
                        <NavDropdown title="Danh muc" id="basic-nav-dropdown">
                            {categories.map(c => <Link key={c.id} to={`/?categoryId=${c.id}`} className="dropdown-item">{c.name}</Link>)}
                        </NavDropdown>
                        <Link to="/register" className="nav-link text-success">Đăng ký</Link>
                        <Link to="/login" className="nav-link text-danger">Đăng nhập</Link>
                    </Nav>

                    <Form className="d-flex" onSubmit={search}>
                        <Form.Control
                            type="search"
                            value={kw} onChange={e => setKw(e.target.value)}
                            placeholder="Tim san pham"
                            className="me-2"
                            aria-label="Search"
                        />
                        <Button type="submit" variant="outline-success">Search</Button>
                    </Form>
                </Navbar.Collapse>
            </Container>
        </Navbar>
    );
}

export default Header;