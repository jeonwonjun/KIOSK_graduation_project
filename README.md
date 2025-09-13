# KIOSK_graduation_project

```
-- 상품데이터
CREATE TABLE product (
    product_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    category VARCHAR(50) NOT NULL,
    brand VARCHAR(50),
    price INT NOT NULL,
    description TEXT,
    is_on_sale BOOLEAN DEFAULT FALSE,
    discount INT DEFAULT 0,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB;

-- 성능을 위한 인덱스
CREATE INDEX idx_product_category ON product(category);
CREATE INDEX idx_product_brand ON product(brand);
CREATE INDEX idx_product_name ON product(name);

-- 매장 데이터
CREATE TABLE store (
    store_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    location VARCHAR(200) NOT NULL,
    latitude DECIMAL(10,7),
    longitude DECIMAL(10,7),
    contact VARCHAR(20)
) ENGINE=InnoDB;

-- 재고 데이터
CREATE TABLE inventory (
    inventory_id INT AUTO_INCREMENT PRIMARY KEY,
    product_id INT NOT NULL,
    store_id INT NOT NULL,
    stock INT NOT NULL DEFAULT 0,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT fk_inventory_product FOREIGN KEY (product_id) REFERENCES product(product_id) ON DELETE CASCADE,
    CONSTRAINT fk_inventory_store FOREIGN KEY (store_id) REFERENCES store(store_id) ON DELETE CASCADE
);

-- 검색/조회 성능용 인덱스
CREATE INDEX idx_inventory_store_product ON inventory(store_id, product_id);

```
