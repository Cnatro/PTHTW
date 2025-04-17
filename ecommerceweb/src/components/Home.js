import { useEffect, useState } from "react";
import Apis, { endpoints } from "../configs/Apis";
import { Alert, Button, Card, Col, Row, Spinner } from "react-bootstrap";
import { useSearchParams } from "react-router-dom";

const Home = () => {
    const [products, setProducts] = useState([]);
    const [q] = useSearchParams();
    const [page, setPage] = useState(1);
    const [loading, setLoading] = useState(false);

    const loadProducts = async () => {
        try {
            setLoading(true);

            let url = `${endpoints['products']}?page=${page}`;

            let categoryId = q.get("categoryId");

            if (categoryId) {
                url = `${url}&categoryId=${categoryId}`;
            }

            let kw = q.get("kw");
            if (kw)
                url = `${url}&kw=${kw}`;

            let res = await Apis.get(url);
            if (res.data.length == 0) {
                setPage(0);
            }
            else {
                if (page == 1)
                    setProducts(res.data);
                else
                    setProducts([...products, ...res.data]);
            }

        } catch {
            //....
        } finally {
            setLoading(false);
        }
    }

    useEffect(() => {
        if (page > 0)
            loadProducts();
    }, [page, q])

    useEffect(() => {
        setPage(1);
        setProducts([]);
    }, [q]);

    const loadMore = () => {
        if (!loading && page > 0)
            setPage(page + 1);
    }
    return (
        <>
            {loading && <Spinner animation="border" variant="primary" />}
            {products.length === 0 && <Alert variant="info" className="mt-1">Không có sản phẩm nào!</Alert>}
            <Row>
                {products.map(p => <Col className="p-1" key={p.id} md={3} xs={6}>
                    <Card style={{ width: '18rem' }}>
                        <Card.Img variant="top" src={p.image} />
                        <Card.Body>
                            <Card.Title>{p.name}</Card.Title>
                            <Card.Text>
                                {p.price.toLocaleString()} VNĐ
                            </Card.Text>
                            <Button className="m-1" variant="primary">Xem chi tiết</Button>
                            <Button className="m-1" variant="danger">Đặt hàng</Button>
                        </Card.Body>
                    </Card>
                </Col>)}
            </Row>

            {page > 0 && <div className="text-center m-1">
                <Button variant="success" onClick={loadMore}>Xem thêm...</Button>
            </div>}
        </>
    );
}

export default Home;