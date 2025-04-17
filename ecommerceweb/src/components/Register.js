import { useRef, useState } from "react";
import { Button, FloatingLabel, Form } from "react-bootstrap";

const Register = () => {
    const info = [{
        label: "Tên",
        type: "text",
        field: "firstName"
    }, {
        label: "Họ và tên lót",
        type: "text",
        field: "lastName"
    }, {
        label: "Tên đăng nhập",
        type: "text",
        field: "username"
    }, {
        label: "Mật khẩu",
        type: "password",
        field: "password"
    }, {
        label: "Xác nhận mật khẩu",
        type: "password",
        field: "confirm"
    }, {
        label: "Điện thoại",
        type: "tel",
        field: "phone"
    }, {
        label: "Email",
        type: "email",
        field: "email"
    }];
    const [user, setUser] = useState({});
    const avatar = useRef();


    const register = (e) => {
        e.preventDefault();
    };

    const setState = (value, field)=>{
        setUser({...user,[field] : value});
    };


    return (
        <>
            <h1 className="text-center text-success mt-1">ĐĂNG KÝ NGƯỜI DÙNG</h1>

            {/* {msg && <Alert variant="danger">{msg}</Alert>} */}

            <Form onSubmit={register}>
                {info.map(f => <FloatingLabel key={f.field} controlId="floatingInput" label={f.label} className="mb-3">
                    <Form.Control type={f.type} placeholder={f.label} required value={user[f.field]} onChange={e => setState(e.target.value, f.field)} />
                </FloatingLabel>)}

                <FloatingLabel controlId="floatingInput" label="Ảnh sản phẩm" className="mb-3">
                    <Form.Control type="file" placeholder="Ảnh sản phẩm" ref={avatar} />
                </FloatingLabel>

                <Button type="submit" variant="success" className="mt-1 mb-1">Đăng ký</Button>
                {/* {loading ? <MySpinner />:<Button type="submit" variant="success" className="mt-1 mb-1">Đăng ký</Button>} */}
                
            </Form>
        </>
    );
}

export default Register;