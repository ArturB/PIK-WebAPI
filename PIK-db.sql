PGDMP     9    0                 u           postgres    9.6.2    9.6.2     `           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                       false            a           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                       false                        2615    16454    pik    SCHEMA        CREATE SCHEMA pik;
    DROP SCHEMA pik;
             pik    false            �            1259    16455    point    TABLE     �   CREATE TABLE point (
    id integer NOT NULL,
    latitude double precision NOT NULL,
    longitude double precision NOT NULL,
    name text,
    owner integer NOT NULL
);
    DROP TABLE pik.point;
       pik         pik    false    6            �            1259    16461    point_id_seq    SEQUENCE     n   CREATE SEQUENCE point_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
     DROP SEQUENCE pik.point_id_seq;
       pik       pik    false    6    187            b           0    0    point_id_seq    SEQUENCE OWNED BY     /   ALTER SEQUENCE point_id_seq OWNED BY point.id;
            pik       pik    false    188            �            1259    16463    user    TABLE     f   CREATE TABLE "user" (
    id integer NOT NULL,
    login text NOT NULL,
    passhash text NOT NULL
);
    DROP TABLE pik."user";
       pik         pik    false    6            �            1259    16469    user_id_seq    SEQUENCE     m   CREATE SEQUENCE user_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
    DROP SEQUENCE pik.user_id_seq;
       pik       pik    false    189    6            c           0    0    user_id_seq    SEQUENCE OWNED BY     /   ALTER SEQUENCE user_id_seq OWNED BY "user".id;
            pik       pik    false    190            �           2604    16495    point id    DEFAULT     V   ALTER TABLE ONLY point ALTER COLUMN id SET DEFAULT nextval('point_id_seq'::regclass);
 4   ALTER TABLE pik.point ALTER COLUMN id DROP DEFAULT;
       pik       pik    false    188    187            �           2604    16496    user id    DEFAULT     V   ALTER TABLE ONLY "user" ALTER COLUMN id SET DEFAULT nextval('user_id_seq'::regclass);
 5   ALTER TABLE pik."user" ALTER COLUMN id DROP DEFAULT;
       pik       pik    false    190    189            Z          0    16455    point 
   TABLE DATA                     pik       pik    false    187   >       d           0    0    point_id_seq    SEQUENCE SET     4   SELECT pg_catalog.setval('point_id_seq', 11, true);
            pik       pik    false    188            \          0    16463    user 
   TABLE DATA                     pik       pik    false    189   <       e           0    0    user_id_seq    SEQUENCE SET     3   SELECT pg_catalog.setval('user_id_seq', 16, true);
            pik       pik    false    190            �           2606    16474    user login_unique 
   CONSTRAINT     H   ALTER TABLE ONLY "user"
    ADD CONSTRAINT login_unique UNIQUE (login);
 :   ALTER TABLE ONLY pik."user" DROP CONSTRAINT login_unique;
       pik         pik    false    189    189            �           2606    16476    point point_pkey 
   CONSTRAINT     G   ALTER TABLE ONLY point
    ADD CONSTRAINT point_pkey PRIMARY KEY (id);
 7   ALTER TABLE ONLY pik.point DROP CONSTRAINT point_pkey;
       pik         pik    false    187    187            �           2606    16478    user user_pkey 
   CONSTRAINT     G   ALTER TABLE ONLY "user"
    ADD CONSTRAINT user_pkey PRIMARY KEY (id);
 7   ALTER TABLE ONLY pik."user" DROP CONSTRAINT user_pkey;
       pik         pik    false    189    189            �           2606    16497 !   point fkldgo1wxsvra0k9wasmcs8smpc    FK CONSTRAINT     q   ALTER TABLE ONLY point
    ADD CONSTRAINT fkldgo1wxsvra0k9wasmcs8smpc FOREIGN KEY (owner) REFERENCES "user"(id);
 H   ALTER TABLE ONLY pik.point DROP CONSTRAINT fkldgo1wxsvra0k9wasmcs8smpc;
       pik       pik    false    189    187    2018            �           2606    16479    point owner_id    FK CONSTRAINT     �   ALTER TABLE ONLY point
    ADD CONSTRAINT owner_id FOREIGN KEY (owner) REFERENCES "user"(id) ON UPDATE CASCADE ON DELETE CASCADE;
 5   ALTER TABLE ONLY pik.point DROP CONSTRAINT owner_id;
       pik       pik    false    2018    189    187            Z   �   x���M��0����E��tZeO.+KqQ��E��di+���}<<��������b�c�j�f��؎�L�Zw���&gO�����٪���k�ز��Ʉb&T��{���r��oQ�*]y�X
���i�-���7���29�|l�D�٠�P}\��O(WI�,�$C�Yj۞!S!d ������g�#A@�Hr���dX�闺6�=�M��e4�Z��GS[��`�)��      \   �   x���v
Q���WP*-N-RR��L�Q��O���Q(H,.�H,��Ts�	uV�0�QPw,*)-R2
2��5��<I5��׫4'�$�S��z}�3S�(1��׽�*5=���s�a!�D�1f@�Y�yŹ�%�� �`L�y\\ ��~	     