import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class MyFrame extends JFrame {
    Connection conn = null;
    PreparedStatement state = null;
    PreparedStatement stateCustomerId = null;
    PreparedStatement stateProductId = null;
    ResultSet result = null;
    MyModel model = null;

    JTabbedPane tabbedPane = new JTabbedPane();
    JPanel customersTabPanel = new JPanel();
    JPanel cTopPanel = new JPanel();
    JPanel cMidPanel = new JPanel();
    JPanel cBotPanel = new JPanel();
    JPanel productsTabPanel = new JPanel();
    JPanel pTopPanel = new JPanel();
    JPanel pMidPanel = new JPanel();
    JPanel pBotPanel = new JPanel();
    JPanel ordersTabPanel = new JPanel();
    JPanel oTopPanel = new JPanel();
    JPanel oMidPanel = new JPanel();
    JPanel oBotPanel = new JPanel();


    JButton caddButton = new JButton("Add");
    JButton cdelButton = new JButton("Delete");
    JButton ceditButton = new JButton("Edit");
    JButton csearchButton = new JButton("Search");
    JButton paddButton = new JButton("Add");
    JButton pdelButton = new JButton("Delete");
    JButton peditButton = new JButton("Edit");
    JButton psearchButton = new JButton("Search");
    JButton oaddButton = new JButton("Add");
    JButton odelButton = new JButton("Delete");
    JButton oeditButton = new JButton("Edit");
    JButton osearchButton = new JButton("Search");


    JTextField fnametf = new JTextField();
    //JTextField lnametf = new JTextField();
    JTextField addresstf = new JTextField();
    JTextField phonetf = new JTextField();
    JTextField emailtf = new JTextField();
    JTextField pNameTF = new JTextField();
    JTextField pDescrTF = new JTextField();
    JTextField pPriceTF = new JTextField();
    JTextField oAddressTF = new JTextField();
    JTextField oQuantityTF = new JTextField();

    JComboBox customerCombo = new JComboBox();
    JComboBox productCombo = new JComboBox();

    JLabel fnameLabel = new JLabel("First Name");
    //JLabel lnameLabel = new JLabel("Last Name");
    JLabel addressLabel = new JLabel("Address");
    JLabel phoneLabel = new JLabel("Phone");
    JLabel emailLabel = new JLabel("E-mail");
    JLabel pNameLabel = new JLabel("Name");
    JLabel pDescrLabel = new JLabel("Description");
    JLabel pPriceLabel = new JLabel("Price");

    JLabel customerNameLabel = new JLabel("Customer name");
    JLabel productNameLabel = new JLabel("Product name");
    JLabel shipAddressLabel = new JLabel("Shipping address");
    JLabel quantityLabel = new JLabel("Quantity");


    JTable customersTable = new JTable();
    JTable productsTable = new JTable();
    JTable ordersTable = new JTable();
    JScrollPane customersScroller = new JScrollPane(customersTable);
    JScrollPane productsScroller = new JScrollPane(productsTable);
    JScrollPane ordersScroller = new JScrollPane(ordersTable);

    public MyFrame() {
        this.setVisible(true);
        this.setSize(600, 390);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.add(tabbedPane);
        //Customers Tab
        tabbedPane.addTab("Customers", customersTabPanel);
        customersTabPanel.setLayout(new BorderLayout());
        cTopPanel.setLayout(new GridLayout(5, 2));
        cMidPanel.setPreferredSize(new Dimension(50, 50));
        customersTabPanel.add(cTopPanel, BorderLayout.NORTH);
        customersTabPanel.add(cMidPanel, BorderLayout.CENTER);
        customersTabPanel.add(cBotPanel, BorderLayout.SOUTH);

        cTopPanel.add(fnameLabel);
        cTopPanel.add(fnametf);

        cTopPanel.add(addressLabel);
        cTopPanel.add(addresstf);
        cTopPanel.add(emailLabel);
        cTopPanel.add(emailtf);
        cTopPanel.add(phoneLabel);
        cTopPanel.add(phonetf);
        cMidPanel.add(caddButton);
        caddButton.addActionListener(new CustomerAddButtonAction());
        cMidPanel.add(cdelButton);
        cdelButton.addActionListener(new CustomerDeleteButton());
        cMidPanel.add(ceditButton);
        ceditButton.addActionListener(new CustomerEditButtonAction());
        cMidPanel.add(csearchButton);
        csearchButton.addActionListener(new CustomerSearchAction());
        customersScroller.setPreferredSize(new Dimension(570, 160));
        cBotPanel.add(customersScroller);
        //Products Tab
        tabbedPane.addTab("Products", productsTabPanel);
        productsTabPanel.setLayout(new BorderLayout());
        productsTabPanel.add(pTopPanel, BorderLayout.NORTH);
        productsTabPanel.add(pMidPanel, BorderLayout.CENTER);
        productsTabPanel.add(pBotPanel, BorderLayout.SOUTH);

        pTopPanel.setLayout(new GridLayout(3, 2));
        pTopPanel.add(pNameLabel);
        pTopPanel.add(pNameTF);
        pTopPanel.add(pPriceLabel);
        pTopPanel.add(pPriceTF);
        pTopPanel.add(pDescrLabel);
        pTopPanel.add(pDescrTF);

        pMidPanel.add(paddButton);
        paddButton.addActionListener(new ProductsAddButtonAction());
        pMidPanel.add(pdelButton);
        pdelButton.addActionListener(new ProductDeleteButton());
        pMidPanel.add(peditButton);
        peditButton.addActionListener(new ProductEditButtonAction());
        pMidPanel.add(psearchButton);
        psearchButton.addActionListener(new ProductSearchAction());

        productsScroller.setPreferredSize(new Dimension(570, 160));
        pBotPanel.add(productsScroller);
        //Orders Tab
        tabbedPane.addTab("Orders", ordersTabPanel);
        ordersTabPanel.setLayout(new BorderLayout());
        ordersTabPanel.add(oTopPanel, BorderLayout.NORTH);
        ordersTabPanel.add(oMidPanel, BorderLayout.CENTER);
        ordersTabPanel.add(oBotPanel, BorderLayout.SOUTH);

        oTopPanel.setLayout(new GridLayout(4, 2));
        oTopPanel.add(customerNameLabel);
        oTopPanel.add(customerCombo);
        oTopPanel.add(productNameLabel);
        oTopPanel.add(productCombo);
        oTopPanel.add(shipAddressLabel);
        oTopPanel.add(oAddressTF);
        oTopPanel.add(quantityLabel);
        oTopPanel.add(oQuantityTF);

        oMidPanel.add(oaddButton);
        oaddButton.addActionListener(new OrdersAddButtonAction());
        oMidPanel.add(odelButton);
        odelButton.addActionListener(new OrdersDeleteButtonAction());
        oMidPanel.add(oeditButton);
        oeditButton.addActionListener(new OrdersEditButtonAction());
        oMidPanel.add(osearchButton);
        osearchButton.addActionListener(new OrdersSearchButtonAction());

        ordersScroller.setPreferredSize(new Dimension(570, 160));
        oBotPanel.add(ordersScroller);
        getAllCustomerData();
        getAllProductData();
        getAllOrdersData();
        fillCustomerCombo();
        fillProductCombo();
    }

    public void fillCustomerCombo() {
        conn = DBConnector.getConnected();
        String sql = "select FNAME from CUSTOMERS";
        try {
            state = conn.prepareStatement(sql);
            result = state.executeQuery();
            customerCombo.removeAllItems();
            while (result.next()) {
                customerCombo.addItem(result.getString("Fname"));
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void fillProductCombo() {
        conn = DBConnector.getConnected();
        String sql = "select PNAME from PRODUCTS";
        try {
            state = conn.prepareStatement(sql);
            result = state.executeQuery();
            productCombo.removeAllItems();
            while (result.next()) {
                productCombo.addItem(result.getString("PNAME"));
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    class CustomerEditButtonAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent arg0) {
            String fName = fnametf.getText();
            //String lName = lnametf.getText();
            String cAddress = addresstf.getText();
            String email = emailtf.getText();
            int phone = Integer.parseInt(phonetf.getText());
            String sql = "UPDATE CUSTOMERS SET ADDRESS=?,EMAIL=?,PHONE=? WHERE FNAME = ?;";
            conn = DBConnector.getConnected();
            try {
                state = conn.prepareStatement(sql);
                state.setString(4, fName);
                //state.setString(2, lName);
                state.setString(1, cAddress);
                state.setString(2, email);
                state.setInt(3, phone);
                state.execute();
                getAllCustomerData();
                fillCustomerCombo();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    class CustomerAddButtonAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent arg0) {
            String fName = fnametf.getText();
            //String lName = lnametf.getText();
            String cAddress = addresstf.getText();
            String email = emailtf.getText();
            int phone = Integer.parseInt(phonetf.getText());

            String sql = "insert into CUSTOMERS(fname,address,email,phone) values(?,?,?,?);";

            conn = DBConnector.getConnected();
            try {
                state = conn.prepareStatement(sql);
                state.setString(1, fName);
                //state.setString(2, lName);
                state.setString(2, cAddress);
                state.setString(3, email);
                state.setInt(4, phone);
                state.execute();
                getAllCustomerData();
                customerCombo.removeAllItems();
                fillCustomerCombo();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    class CustomerDeleteButton implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent arg0) {
            String fName = fnametf.getText();

            String sql = "DELETE from customers where fname=?";

            conn = DBConnector.getConnected();
            try {
                state = conn.prepareStatement(sql);
                state.setString(1, fName);
                state.execute();
                getAllCustomerData();
                getAllOrdersData();
                fillCustomerCombo();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    class CustomerSearchAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            conn = DBConnector.getConnected();
            String fName = fnametf.getText();
            String sql = "select * from CUSTOMERS where fname=?";

            try {
                state = conn.prepareStatement(sql);
                state.setString(1, fName);
                result = state.executeQuery();
                customersTable.setModel(new MyModel(result));
            } catch (SQLException e1) {
                e1.printStackTrace();
            } catch (Exception e1) {
                e1.printStackTrace();
            } finally {
                try {
                    conn.close();
                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        }

    }

    public void getAllCustomerData() {
        conn = DBConnector.getConnected();
        String sql = "select fname,address,email,phone from CUSTOMERS";
        try {
            state = conn.prepareStatement(sql);
            result = state.executeQuery();
            model = new MyModel(result);
            customersTable.setModel(model);

        } catch (SQLException e1) {
            e1.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void getAllProductData() {
        conn = DBConnector.getConnected();
        String sql = "select pname,price,description from products";
        try {
            state = conn.prepareStatement(sql);
            result = state.executeQuery();
            model = new MyModel(result);
            productsTable.setModel(model);

        } catch (SQLException e1) {
            e1.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    class ProductsAddButtonAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent arg0) {
            String pName = pNameTF.getText();
            String description = pDescrTF.getText();
            double price = Double.parseDouble(pPriceTF.getText());
            String sql = "insert into PRODUCTS(pname,price,description) values(?,?,?);";
            conn = DBConnector.getConnected();
            try {
                state = conn.prepareStatement(sql);
                state.setString(1, pName);
                state.setDouble(2, price);
                state.setString(3, description);
                state.execute();
                getAllProductData();
                fillProductCombo();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    class ProductDeleteButton implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent arg0) {
            String pName = pNameTF.getText();

            String sql = "DELETE from PRODUCTS where Pname=?";

            conn = DBConnector.getConnected();
            try {
                state = conn.prepareStatement(sql);
                state.setString(1, pName);
                state.execute();
                getAllProductData();
                getAllOrdersData();
                fillProductCombo();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    class ProductSearchAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            conn = DBConnector.getConnected();
            String pName = pNameTF.getText();
            String sql = "select * from PRODUCTS WHERE Pname=?";

            try {
                state = conn.prepareStatement(sql);
                state.setString(1, pName);
                result = state.executeQuery();
                productsTable.setModel(new MyModel(result));
            } catch (SQLException e1) {
                e1.printStackTrace();
            } catch (Exception e1) {
                e1.printStackTrace();
            } finally {
                try {
                    conn.close();
                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        }

    }

    class ProductEditButtonAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent arg0) {
            String pName = pNameTF.getText();
            String description = pDescrTF.getText();
            double price = Double.parseDouble(pPriceTF.getText());
            String sql = "UPDATE PRODUCTS SET DESCRIPTION=?,PRICE=? WHERE PNAME = ?;";
            conn = DBConnector.getConnected();
            try {
                state = conn.prepareStatement(sql);
                state.setString(3, pName);
                state.setString(1, description);
                state.setDouble(2, price);
                state.execute();
                getAllProductData();
                fillProductCombo();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public void getAllOrdersData() {
        conn = DBConnector.getConnected();
        String sql = "SELECT c.FNAME,o.order_date,o.ship_address,pname,price,quantity,price*quantity as total\n" +
                "from CUSTOMERS c join ORDERS o\n" +
                "on c.CUSTOMER_ID = o.CUSTOMER_ID\n" +
                "join products p\n" +
                "on p.product_id=o.product_id\n";
        try {
            state = conn.prepareStatement(sql);
            result = state.executeQuery();
            model = new MyModel(result);
            ordersTable.setModel(model);

        } catch (SQLException e1) {
            e1.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    class OrdersAddButtonAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent arg0) {
            String oCustomerName = customerCombo.getSelectedItem().toString();
            String oProductName = productCombo.getSelectedItem().toString();
            int quantity = Integer.parseInt(oQuantityTF.getText());
            String shipping = oAddressTF.getText();
            String sqlAddCustomer = "select customer_id from customers where fname=?";
            String sqlAddProduct = "select product_id from products where pname=?";
            String sql = "insert into orders(customer_id ,ship_address ,product_id ,quantity)\n" +
                    "values (?,?,?,?)";
            String resultIdCustomer = null;
            String resultIdProduct = null;
            conn = DBConnector.getConnected();
            try {
                stateCustomerId = conn.prepareStatement(sqlAddCustomer);
                stateCustomerId.setString(1, oCustomerName);
                result=stateCustomerId.executeQuery();
                if (result.next()) {
                    resultIdCustomer = result.getString(1);
                }

                stateCustomerId.execute();
                getAllOrdersData();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            int resultIdCustomer1=Integer.parseInt(resultIdCustomer);
            conn = DBConnector.getConnected();
            try {
                stateProductId = conn.prepareStatement(sqlAddProduct);
                stateProductId.setString(1, oProductName);
                result=stateProductId.executeQuery();
                if (result.next()) {
                    resultIdProduct = result.getString(1);
                }

                stateProductId.execute();
                getAllOrdersData();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            int resultIdProducts1=Integer.parseInt(resultIdProduct);
            conn = DBConnector.getConnected();
            try {
                state = conn.prepareStatement(sql);
                state.setInt(1, resultIdCustomer1);
                state.setInt(3, resultIdProducts1);
                state.setInt(4,quantity);
                state.setString(2, shipping);
                state.execute();
                getAllOrdersData();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }

    }

    class OrdersEditButtonAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent arg0) {
            String oCustomerName = customerCombo.getSelectedItem().toString();
            String oProductName = productCombo.getSelectedItem().toString();
            int quantity = Integer.parseInt(oQuantityTF.getText());
            String shipping = oAddressTF.getText();
            String sqlAddCustomer = "select customer_id from customers where fname=?";
            String sqlAddProduct = "select product_id from products where pname=?";
            String sql = "UPDATE ORDERS SET SHIP_ADDRESS=?,PRODUCT_ID=?,QUANTITY=? WHERE CUSTOMER_ID = ?;";
            String resultIdCustomer = null;
            String resultIdProduct = null;
            conn = DBConnector.getConnected();
            try {
                stateCustomerId = conn.prepareStatement(sqlAddCustomer);
                stateCustomerId.setString(1, oCustomerName);
                result=stateCustomerId.executeQuery();
                if (result.next()) {
                    resultIdCustomer = result.getString(1);
                }

                stateCustomerId.execute();
                getAllOrdersData();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            int resultIdCustomer1=Integer.parseInt(resultIdCustomer);
            conn = DBConnector.getConnected();
            try {
                stateProductId = conn.prepareStatement(sqlAddProduct);
                stateProductId.setString(1, oProductName);
                result=stateProductId.executeQuery();
                if (result.next()) {
                    resultIdProduct = result.getString(1);
                }

                stateProductId.execute();
                getAllOrdersData();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            int resultIdProducts1=Integer.parseInt(resultIdProduct);
            conn = DBConnector.getConnected();
            try {
                state = conn.prepareStatement(sql);
                state.setInt(4, resultIdCustomer1);
                state.setInt(2, resultIdProducts1);
                state.setInt(3,quantity);
                state.setString(1, shipping);
                state.execute();
                getAllOrdersData();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }

    }

    class OrdersDeleteButtonAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent arg0) {
            String oCustomerName = customerCombo.getSelectedItem().toString();
            String sqlAddCustomer = "select customer_id from customers where fname=?";
            String sql = "DELETE FROM orders WHERE CUSTOMER_ID = ?;";
            String resultIdCustomer = null;
            conn = DBConnector.getConnected();
            try {
                stateCustomerId = conn.prepareStatement(sqlAddCustomer);
                stateCustomerId.setString(1, oCustomerName);
                result=stateCustomerId.executeQuery();
                if (result.next()) {
                    resultIdCustomer = result.getString(1);
                }
                stateCustomerId.execute();
                getAllOrdersData();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            int resultIdCustomer1=Integer.parseInt(resultIdCustomer);
            conn = DBConnector.getConnected();
            try {
                state = conn.prepareStatement(sql);
                state.setInt(1, resultIdCustomer1);

                state.execute();
                getAllOrdersData();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }

    }

    class OrdersSearchButtonAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent arg0) {
            String oCustomerName = customerCombo.getSelectedItem().toString();
            String oProductName = productCombo.getSelectedItem().toString();
            String sqlAddCustomer = "select customer_id from customers where fname=?";
            String sqlAddProduct = "select product_id from products where pname=?";
            String sql = "SELECT c.FNAME,o.order_date,o.ship_address,pname,price,quantity,price*quantity as total\n" +
                    "from CUSTOMERS c join ORDERS o\n" +
                    "on c.CUSTOMER_ID = o.CUSTOMER_ID\n" +
                    "join products p\n" +
                    "on p.product_id=o.product_id \n" +
                    "where c.customer_id=?  and p.product_id=?";
            String resultIdCustomer = null;
            String resultIdProduct = null;
            conn = DBConnector.getConnected();
            try {
                stateCustomerId = conn.prepareStatement(sqlAddCustomer);
                stateCustomerId.setString(1, oCustomerName);
                result=stateCustomerId.executeQuery();
                if (result.next()) {
                    resultIdCustomer = result.getString(1);
                }

                stateCustomerId.execute();
                getAllOrdersData();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            int resultIdCustomer1=Integer.parseInt(resultIdCustomer);
            conn = DBConnector.getConnected();
            try {
                stateProductId = conn.prepareStatement(sqlAddProduct);
                stateProductId.setString(1, oProductName);
                result=stateProductId.executeQuery();
                if (result.next()) {
                    resultIdProduct = result.getString(1);
                }

                stateProductId.execute();
                getAllOrdersData();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            int resultIdProducts1=Integer.parseInt(resultIdProduct);
            conn = DBConnector.getConnected();
            try {
                state = conn.prepareStatement(sql);
                state.setInt(1, resultIdCustomer1);
                state.setInt(2, resultIdProducts1);
                state.execute();
                result = state.executeQuery();
                ordersTable.setModel(new MyModel(result));
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }

    }




}

