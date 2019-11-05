CREATE TABLE IF NOT EXISTS movies (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(50) NOT NULL,
  minutes INT NOT NULL,
  genre VARCHAR(50) NOT NULL,
  director VARCHAR(50) NOT NULL
);

insert into movies (name, minutes, genre, director) values
    ('Dark Knight', 152, 'ACTION','Mell Gibson'),
    ('Memento', 113, 'THRILLER', 'Guillermo del Toro'),
    ('Matrix', 136, 'ACTION', 'Camilo Cubillos'),
    ('Dark Phoenix', 190, 'COMEDY', 'Tobias Pacheco'),
    ('Dark Moon', 100, 'THRILLER', 'Camilo Cubillos');